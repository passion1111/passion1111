var myObject={
    name:'foo',
    sayName:function () {
        console.log(this.name);
    }
};

//otherObject생성
var otherObject={
    name:'bar'
}
//otherObject.sayName()메서드
otherObject.sayName=myObject.sayName;
//sayName()메서드 호출
myObject.sayName(); //foo
otherObject.sayName(); //bar
//두 오브젝트의 sayname은 각각 불려진 객체를 this로 바인딩한다.

//
