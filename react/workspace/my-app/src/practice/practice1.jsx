import { useState } from "react";
import com01 from "../img/0.png";
import com02 from "../img/1.png";
import com03 from "../img/2.png";

function Practice1(props){
    const [user ,setuser] = useState(null);
    const [com ,setcom] = useState(null);
    const [result, setresult] = useState(null);
    const [history, setHistory] = useState([]);

    const images = [com01, com02, com03];
    const icons = ["✌", "✊", "✋"];

    const onClickResult = (player) =>{
        setuser(images[player]);

    const computer = Math.floor(Math.random() * 3);
        setcom(images[computer]);

   const gameResult = getResult(player, computer);
        setresult(gameResult);

    const historyText = `${icons[player]} vs ${icons[computer]} = ${gameResult}`;
        setHistory([historyText, ...history]);
    };
    const getResult = (user,computer) => {
        if (user === computer) return "무승부";
        if(
            (user === 0 && computer === 2) ||
            (user === 1 && computer === 0) || 
            (user === 2 && computer === 1) 
        ) {
            return "승리";
        }
        return "패배";
    
    };
       
     return (
        <div style={{ display: "flex", flexDirection: "column", alignItems: "center" }}>
        <div style={{ display: "flex", justifyContent: "center", alignItems: "center" }}>
        <div style={{ textAlign: "center" }}>
            <h3>유저</h3>
            {user && <img src={user} alt="유저"/>}
        </div>
        <div>
            <h1>vs</h1>
        </div>
        <div style={{ textAlign: "center" }}>
            <h3>컴퓨터</h3>
            {com && <img src={com} alt="컴퓨터"/>}
        </div>
        </div>
        <div style={{ textAlign: "center" }}>
        <h2>결과: {result}</h2>
        </div>
        <div style={{ marginTop: "10px" }}>
        <button onClick={() => onClickResult(0)}>✌</button>
        <button onClick={() => onClickResult(1)}>✊</button>
        <button onClick={() => onClickResult(2)}>✋</button>
        </div>
        <div style={{  textAlign: "center" }}>
        <h3>기록</h3>
        {history.map((data, index) => (
            <p key={index}>{data}</p>
        ))}
        </div>
    </div>
    );

    }

export default Practice1;