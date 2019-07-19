var btns=[
    document.getElementById('btn0'),
    document.getElementById('btn1'),
    document.getElementById('btn2')

];
//------------var로 하니까 그냥 3이 나와버림.
function setclick() {
    for (var i=0; i<3; i++){
        // document.getElementById('btn1').onclick=function(){
        //     console.log(i);
        // }
      //btns[i].onclick=aa으로하고 함수명을 익명말고 aa라고해도 실행됨.
      btns[i].onclick=function(){
            console.log(i);
        
        }
        a=3;
        console.log(a);
    }
}
    console.log(3);

setclick();


//setclick 이 있어야 실행컨텍스트가 만들어지고 그래야 호이스팅으로 만들어질수가 있음.


//-----------------let으로 하면 해당하는 버튼값이 불려짐.
// var btns=[
//         document.getElementById('btn0'),
//         document.getElementById('btn1'),
//         document.getElementById('btn2')
    
//     ];
//    //let일떄는 됨
//     function setclick() {
//         for (let i=0; i<3; i++){
//             btns[i].onclick=function(){
//                 console.log(i);
    
//             }
//         }
//     }
        
    
//     setclick();

    //---------var은 함수단위 let은 중괄호단위
    //그래서 var은 무조건 3 let은 누르는것에 해당하는 값.
//     function x(){
// { 
//         //    var t=1;
//         let t=1;
// }//t는 중괄호와는 상관없고 함수의 스코프에 들어감. let은 중괄호 안에 생겨버림.
// //만약 중괄호가 여러개가있으면 그 안에서만 변수가 존재하게됨.
//     console.log(t);
//     }
//     x(); //이상태로 하면 t 불러주면에러가 떠버림.왜냐? let은 중괄호안에만 존재
//var는 체인스코프로 연결돼있는데 자기가 값을 안가지고있으면
// 상위 i의 값을 호출함 근데 i는3이니까 3을 호출하게 되는방식.
// i3이라는값도 못찾으면 그 상위에 있는 값들을 찾게된다.

// let은 작은 중괄호의 개념에서부터 큰 중괄호의 개념으로
// 확장돼서검색함.
// let의 for문은 중괄호 안에 {}선언이 됨. 그래서 let은 for문 돌떄마다
// 새로운 i가 생성이됨.