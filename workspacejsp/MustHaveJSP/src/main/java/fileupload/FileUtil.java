package fileupload;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public class FileUtil {
	public static String uploadFile(HttpServletRequest req, String sDirectory) throws IOException, ServletException {
		Part part = req.getPart("ofile");
		String partHeader = part.getHeader("content-disposition");
		String [] phArr = partHeader.split("filename=");
		String originalFileName = phArr[1].trim().replace("\"", "");
		if(!originalFileName.isEmpty()) {
			part.write(sDirectory + File.separator + originalFileName);
		}
		return originalFileName;
	}
	public static String renameFile(String sDirectory, String fileName) {
		String ext = fileName.substring(fileName.lastIndexOf("."));
		String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
		String newFileName = now + ext;
		File oldFile = new File(sDirectory + File.separator + fileName);
		File newFile = new File(sDirectory + File.separator + newFileName);
		oldFile.renameTo(newFile);
		return newFileName;
		
	}
	// 파일을 Uploads폴더 저장하고 파일 이름을 List형식으로 돌려주는 메서드 
	public static ArrayList<String> multipleFile(HttpServletRequest req, String sDirectory) throws IOException, ServletException{
		ArrayList<String> listFileName = new ArrayList<>();
		// 여러개의 요청 데이터를 parts변수에 저장
		Collection<Part> parts = req.getParts();
		for(Part part : parts) {
			// 데이터가 ofile이 아니라면 다음 반복을 실행
			if(!part.getName().equals("ofile")) {
				continue;
			}
			// ofile이라면 파일을 꺼내어 저장하는 처리 실행
			String partHeader = part.getHeader("content-disposition");
			String[] phArr = partHeader.split("filename=");
			String originalFileName = phArr[1].trim().replace("\"", "");
			if(!originalFileName.isEmpty()) {
				// 실제 파일을 저장하는 처리
				part.write(sDirectory+File.separator+originalFileName);
			}
			// 파일이름을 List에 저장
			listFileName.add(originalFileName);
		}
		return listFileName;
	}
}










