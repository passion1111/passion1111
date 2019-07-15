var arr=['bar'];

var obj={
    name:'foo',
    length:1
};

arr.push('barz');
console.log(arr);

// obj.push('baz');// obj는 push가 불가능해진다. 왜냐하면 obj는 배열이 아니므로.