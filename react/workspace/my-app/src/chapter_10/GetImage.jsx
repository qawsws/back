import { useState } from "react";
import place01 from "../img/img_place_01.png";
import place02 from "../img/img_place_02.jpg";
function GetImage(props){
    const [image, setImage] = useState(null);
    const onClickBtn = () =>{
        setImage(place01);
    }
    const onClickBtn2 = () =>{
        setImage(place02);
    
}
return (
        <div>
             <img src={image} alt="이미지"/>
            <button onClick={onClickBtn}>버튼</button>
            <button onClick={onClickBtn2}>버튼</button>
            {/* import를 이용한 이미지 출력 */}
            <img src={place01} alt="이미지"/>
            {/* 웹 주소를 이용한 이미지 출력 */}
            <img src="https:////upload.wikimedia.org/wikipedia/commons/thumb/6/6e/Golde33443.jpg/330px-Golde33443.jpg" alt="강아지"/>
            {/* public폴더의 이미지 출력 */}
            <img src="/logo512.png" alt="로고"/>
        
        </div>
    );
}
export default GetImage;