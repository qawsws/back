import React from "react";
import Notification from "./Notification";

const reservedNotifications = [
    {
        id:1, message: "안녕하세요, 오늘 일정을 알려드립니다.",
    },
     {
        id:2, message: "점심 식사 시간입니다.",
    },
      {
        id:3, message: "이제 곧 미팅 시작입니다.",
    },
];

var timer;

class NotificationList extends React.Component { 
    constructor(props) {
        super(props);

        this.state = {
            notifications: [],
            count:0
        };
    }

    componentDidMount() {
        // state의 값을 상수에 저장 
        const { notifications } = this.state;
        // 1초에 한번식 실행
        timer = setInterval(() => {
            // notifications가 reservedNotifications의 데이터 개수보다 작으면
            // reservedNotifications의 데이터를 notification에 저장하는 if문
            // state에 데이터를 1초에 한번식 저장하면 1초에 한번식 화면에 갱신
            if (notifications.length < reservedNotifications.length) {
                // 현재 state가 가지고 있는 데이터 개수 저장
                const index = notifications.length;
                // state에 저장할 데이터를 작성
                notifications.push(reservedNotifications[index]);
                // setstate를 이용하여 state데이터를 변경
                this.setState({
                    notifications: notifications,
                });
            }else{
                clearInterval(timer);
                // state안에 들어있는 3개의 데이터를 빈배열로 변경
                this.setState({notifications:[]})
            }
        }, 1000);
    }
    componentWillUnmount(){
        if (timer) {
            clearInterval(timer);
        }
    }

    render(){
        return(
            <div>
                {this.state.notifications.map((notification) => {
                    return <Notification key={notification.id} id={notification.id} message={notification.message} />;
                })}
            </div>
        );
    }
}

export default NotificationList;