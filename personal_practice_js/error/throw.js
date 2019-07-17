// function sum(x,y){
//     return x+y;
// }

// console.log(sum(('a'),2)); //결과가 a2라고 나오므로


function sum(x,y) {
        if(typeof x!=='number'
        || typeof y!=='number'){
            throw  '숫자가 아니에여'
        }
        return x+y;
        }
        console.log(sum('a',2));