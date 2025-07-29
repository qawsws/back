function MyButton(props){
    const [isclicked, setIsClicked] = React.useState(false);

    return React.createElement(
        'button',
        { onClick: () => setIsClicked(true)},
        isclicked ? 'Clicked!' : 'Click here!'
    )
}
// root : index.html에 있는 root태그 안의 내용이 바뀌도록 설정
const domContainer =  document.querySelector('#root');
// root태그를 React에서 사용하는 root로 설정
const root = ReactDOM.createRoot(domContainer);
// root태그 안에 React로 구현한 내용을 렌더링 하는 코드
root.render(React.createElement(MyButton));
