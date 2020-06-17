var readline=require('readline')
var {EOF}=require('os')
var rl=readline.createInterface({
    input:process.stdin,
    output:process.stdout
})

let input=[];
rl.on('line',line=>{
   input.push(line)
//          line.split(' '). or split('').map(e=>parseInt(e))
}).on('close',()=>{
process.stdout.write(input.toString())
//console.log(input)
})
