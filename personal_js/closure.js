// function outer(){
//     var a=1;
//     console.log(a);  //a에 무슨값이 들어있는지 찾는것이 스코프
//                     //a라는곳에 1이 들어가있다 -< 스코프
//                     //스코프는 아우터에 포함돼있음.즉 함수 단위

// }

// // outer();
// var d= 'x';
// function outer(){  //oter 스코프 한개
//     var a=1;
//     var b='b';
//     function inner(){   //inner 스코프 한개 inner에서 확인
//     var a=2;
//         console.log(a); 
//         console.log(b);  //inner에서 b가 없으니 상위 oter에서 스코프를 확인.
//                         //오버라이딩과 비슷한 느낌인가?
    
//         console.log(d);   //inner -> outer->전역변수 순으로 스코프를 확인
//                         //스코프끼리 연결돼있으니 이것을 스코프 체인이라고 한다.     
//          }

// inner();
// }

// outer();


//클로져란 생성한 시점에 스코프체인을 계속 들고있는다는 개념.

var d='x';
function outer(){
    var a=1;
    var b='b';

    function inner(){
        var a=2;
        console.log(b);
    }
    return inner
}

var someFun=outer();
someFun();//outer가 실행되고 inner값을 return하면서 
// var b가 사라지는것으로 생각하기 쉬운데 클로져란
// 생성되는순간 스코프체인이 만들어져서 계속 