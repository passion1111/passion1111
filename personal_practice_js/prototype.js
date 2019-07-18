import { prependListener } from "cluster";
import { request } from "https";

// var adds=[1,2,3];
//배열 타입을 예시로 들면 add가 있고 여기안에 1,2,3이 들어가있다.
//이떄 값은 좌표값을 참조하도록 돼있음.


// var add=function(x,y){
// return x+y;
// }
//add인 함수객체는 add가 생성되면 자연스럽게 프로토타입프로퍼티가 생김.
//추가로 _proto_가 생김. 
//프로토타입 프로퍼티라는것은 함수가 만들어지는순간 add.prototype이 만들어짐.
//add.prototype안에는 add함수 객체를 지칭하는 constructor가 들어가있음.
//그래서 add함수객체의 프로퍼티가 컨스트럭터를 지칭하고 컨스트럭터는
//add함수 객체를 가지고있음.

//_proto_는 펑션 프로토타입을 지칭하고있음.

//함수가 생성되는순간 위에 과정이 만들어짐.

//_proto_

// console.log(add.prototype.constructor===add);//true
//프로토타입생성자와 add는 같다 


//-------------객체의 this바인딩
// var korNmae={
//     name:"kim",
//     sayName:function(){
//         console.log(this.name);
//     }
// }
// korNmae.sayName(); //kim이 출력됨


// var usName={
//     name:"christy"
// }
// usName.sayName=korNmae.sayName;

// usName.sayName=function(){
//     console.log(this.name)
// }
// //usname에 sayname이라는 프로퍼티를 추가해주는데 그것은 korname의 sayname과 같다.

// usName.sayName(); //christy가 출력하게됨. usname이 불렀기때문에
// //메서드내부코드에서 사용된 this는 해당 메서드를 호출한객첵로 binding된다.


//---------------------------함수의 this 바인딩
// var globalTest="this is global test";
// // console.log(window.test);
// var thistest=function(){
//     console.log(this); //함수안에서의 this는 윈도우를 기준으로 잡아줌. 즉 윈도우창을 의미함.
//     console.log(this.globalTest); //윈도우의 프로퍼티로 globaltest가 들어가있음. 그래서~is global test가 출력됨
// }
// thistest();

//--생성자함수에서의 this
// function Person(name){
//     this.name=name;
// }
// var korName=new Person("kim");
// console.log(korName.name);
//Person()생성자함수에서
//프로토타입 프로퍼티와
//_proto_가 생성되고
// person.prototype 객체에 constructor 프로퍼티가 생성됨.
//korName객체안에  name:kim 이들어가게됨. 
//그래서 생성자함수는 korname객체를 나타내게됨.
// 그리고 korName의 _proto_는 person.prototype 객체를 나타내게됨.


//_proto는 부모가 누군지 가르킴.

//--이해하기 위핸 예제 윗글

// function person() {}

// var korName=new person();
// var usName=new person();

// person.prototype.setName=function() {
//     return "kim in joo";
// }
// //둘다 person.prototype을 참조하니 kim in joo라고 출력을 하게 됨.
// //근데 korname에 setname을 할경우?
// korName.setName=function(){
//     return "this is";
// }  //this is를 출력하게됨 korname만 왜냐? 지역변수를 우선하니까
// //person prototype이 바뀌지않았음 왜냐하면 아래는 kim in joo가 출력되니.

// console.log(korName.setName());
// console.log(usName.setName());

// usName.age=31;//usName객체안에 age가 만들어졌음.
// console.log(korName.age);
// console.log(usName.age); //당연히 31이라고 출력

//prototype chain
// function Person(name) {
//     this.name=name;
// }
// var usName=new Person("chri");
// console.dir(Person);
// console.dir(usName);
//prototype 체이닝은 결국  usName객체가  person.prototype객체를 
// 가르키고있는것을 의미.


//객체 리터럴방식으로 생성된 객체 prototype
// var people={
//     name:"inkweon",
//     sayName:function() {
//         console.log("i am"+this.name)//여기서의 name은 people네임을 의미
//     }
// }
// people.sayName();
// console.log(people.hasOwnProperty('name'));//perple안에 어떤 property가 있는지 어떤 기능이 있는지 찾는 메소드
// console.log(people.hasOwnProperty('age'));


people.getName();//존재하지않기떄문에 에러가 뜸.

//People을 만드는순간 그 상위 클래스인 object 생성자 함수가 생기고
// 그안에는 prototype 프로퍼티가 생긴다. 동시에 object.prototype 객체가 만들어지고
//constructor 프로퍼티와 hasownproperty 가 생긴다.
//  그 생성자함수는 People 생성자 함수를 가르키게 되고
// prototype 프로퍼티와 name,sayname의 값을 가지고있는다.그리고 _proto_도
// 가지고있고 그게 hasownProperty를 지칭하고있다.
//위에는 객체에서의 프로토타입 체이닝

//생성자함수의 프로토타입 체이닝
function Person() {
    this.name=name;
}
var usName=new Person("chri");
console.log(usName.hasOwnProperty('name'));
console.dir(Person.prototype);

//Person()생성자 함수가 생기면서
//prototype 프로퍼티가 생기고 name이 할당
//Person.Prototype객체에서는 constructor 프로퍼티와
// _proto가 생긴다
// usName객체에서는 name:chri와 _proto가 생기는데
// _proto는 person prototype의 _proto을 찾고 
// Person _proto는 object property객체의 hasownProperty값을 참조한다.
