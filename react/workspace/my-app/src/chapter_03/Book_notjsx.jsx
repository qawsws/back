import React from "react";

// Book 컴포넌트 생성
function Book(props){
    // 화면에 출력할 내용들을 적는 JSX작성 공간
    return React.createElement(
        'div',
        null,
        [
            React.createElement(
                'h1',
                null
                `이 책의 이름은 ${props.name}입니다.`
            ),
            React.createElement(
                'h2',
                null,
                `이 책의 총${props.numOfPage}페이지로 이뤄져 있습니다.`
            )
        ]
    )
}
// Book.jsx파일을 불렀을떄 기본으로 돌려주는 함수는 Book으로 설정
export default Book;