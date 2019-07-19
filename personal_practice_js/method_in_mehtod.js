// function parent() {
//     var a=100
//     //child() 내부 함수
//      var child=function () {
//          console.log(a);
//      }
// //child()함수 반환
// return child;
//     }
//     var inner=parent();
//     inner(); //제대로 찍힌다.

    //이와같이 실행이 끝난 parent()와 같은 부모함수스코프의 변수를
    // 참조하는 inner()와같은 함수를 클로저라고한다.

    //---자신을 재정의하는 함수

//self()
// var self=function () {
//     console.log('a');
//     return function () {
//         console.log('b');
//     }
// }

// self=self() //a
// self(); //b
// self=self();//b

//--함수의 인자를 맞추지않아도 출력이됨.
//더 넣어도 더 넣은값이 무시되고 출력이됨.