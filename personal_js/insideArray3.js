var arr=['bar'];
var obj={name:'foo',lenth:1};
arr.push('baz');
console.log(arr);

Array.prototype.push.apply(obj,['baz']);
console.log(obj); 
console.log(!!false);
console.log(!!null);
console.log(!!undefined);
console.log(!!{});
console.log(!![1,2,3]);
//이해필요 다시 공부할 필요성.
