package program.dao;

import java.util.ArrayList;
import java.util.List;

import common.DBConnPool;
import program.dto.ProgramDTO;

public class ProgramDAO extends DBConnPool {

    public List<ProgramDTO> getProgramList() {
        List<ProgramDTO> list = new ArrayList<>();
        String query = "SELECT id, title, text, subtext, schedule, img FROM TOURIST_PROGRAM ORDER BY id";

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                ProgramDTO dto = new ProgramDTO();
                dto.setId(rs.getInt("id"));
                dto.setTitle(rs.getString("title"));
                dto.setText(rs.getString("text"));
                dto.setSubtext(rs.getString("subtext"));
                dto.setSchedule(rs.getString("schedule"));
                dto.setImg(rs.getString("img"));
                list.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
