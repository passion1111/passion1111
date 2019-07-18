//---실행 컨텍스트
// function exeContext(firstParam,secondParam) {
//     var a=100;
//     var b=200;
//     function func() {
//         return a+b;
//     }

//     return firstParam+secondParam+func();
// }
// console.log(exeContext(300,400));


// function test() {
//     var a=100;
//     var b=arguments;
//     return b.length;
// }
// console.log(test());

/* 위에 내용 설명
전역 상단 컨텍스트
활성객체
스코프
execontext
this

실행을 시키고 난다음에는

execontext 실행 컨텍스트
arguments->firstparam  ,secondparam   <--아규먼츠가 있으면 아규먼츠먼저 만들어짐.
								//함수는 아규먼츠가 항상 생기고 매개변수가 없어도 아규먼츠에 접								접근됨 아규먼츠 length해봐도 출력이 됨.
스코프

변수 (var a ,varb) 근데 변수의 최초값은 undefined로 된다.
func함수
this


func함수를 실행했기떄문에
arguments
func실행 컨텍스트
this  

그래서 전역 실행 컨텍스트의 exeContext에서 exeContext에 대한 실행 컨텍스트가 만들어지고
func에대한실행 컨텍스트가 만들어짐.
그리고 모든 함수는 arguments를 가지고 있음. 함수안에만 가지고있음.
그리고 함수를 호출시 arguments가 생성됨.
그리고 실행을 안하면 arguments가 생성안됨 실행컨텍스트도 실행이 안됨.



*/

//-----------호이스팅

// function Showname() {
//     //var name //이상태로 생성이 되는거
    
//     console.log("first name:"+name);//firstname undefined 
//     var name="inin";//name에 값이 할당
//     console.log("Last name :"+name)//last name:inin
// }
// Showname();

//전역 실행 컨텍스트에서 스코프가 만들어지고 쇼우네임이 만들어지고
//디스값이 들어감

//showname이 부렸으니 실행 컨텍스트가 만들어지고
//arguments가 만들어지고
//scope
//var name =definedd
//this


//함수 선언문
kim();
function kim() {
    console.log('call kim');
}

//함수 표현식
lee();
var lee=function() {
    console.log('call lee');
};