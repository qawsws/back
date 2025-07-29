import Comment from "./Comment";

const comments = [
    {name:"이인제", comment:"안녕하세요, 소플입니다."},
    {name:"유재석", comment:"리액트 재미있어요~!~!"},
    {name:"강호동", comment:"저도 리액트 하고 싶어여!!"},
]

function CommentList(props){
    return(
        <div>
            <Comment name="이인제" comment="제가 만든 첫 컴포넌트 입니다" />
            <Comment name="유재석" comment="리액트 웩우우엑우게우엑" />
            {/* comments 배열을 map을 이용하여 반복 */}
            {comments.map((comment)=>{
                // comments의 내용을 이용하여 Comment 컴포넌트를 반환
                return <Comment name={comment.name} comment={comment.comment}/>
            })}
        </div>
    );
}
export default CommentList;