import { useRef, useState } from "react";

function Register(props) {
  const [id, setId] = useState("");
  const [pw, setPw] = useState("");
  const [pwc, setPwc] = useState("");
  const [errorMsg, setErrorMsg] = useState("");

  const nickRef = useRef("");

  // 가상의 중복 아이디 (예시)
  const existingUser = "test";

  const handleSubmit = (event) => {
    event.preventDefault(); // 기본 동작 먼저 차단

    if (!id || !pw || !pwc) {
      setErrorMsg("빈칸을 모두 입력하세요.");
      return;
    }
    if (pw !== pwc) {
      setErrorMsg("비밀번호가 일치하지 않습니다.");
      return;
    }
    if (id === existingUser) {
      setErrorMsg("이미 존재하는 계정입니다.");
      return;
    }

    alert("회원가입 완료!");
    setErrorMsg("");
  };

  const buttonStyle = {
    width: "100%",
    padding: "10px",
    backgroundColor: "#ccc",
    border: "none",
    color: "#fff",
    fontWeight: "bold",
    cursor: "pointer",
    marginTop: "10px"
  };

  return (
    <div style={{ width: "300px", margin: "100px auto", textAlign: "center" }}>
      <h2>회원가입</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="아이디"
          value={id}
          onChange={(e) => setId(e.target.value)}
        /><br />
        <input
          type="password"
          placeholder="비밀번호"
          value={pw}
          onChange={(e) => setPw(e.target.value)}
        /><br />
        <input
          type="password"
          placeholder="비밀번호 확인"
          value={pwc}
          onChange={(e) => setPwc(e.target.value)}
        /><br />
        {errorMsg && <p style={{ color: "gray", fontSize: "12px" }}>{errorMsg}</p>}
        <button type="submit" style={buttonStyle}>회원가입</button>
      </form>
    </div>
  );
}

export default Register;
