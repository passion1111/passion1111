const path= require('path');
// 

module.exports={
 mode:"production",
 extry:"./index.js",
 output:{path:path.resolve(__dirname,'public'),
 filename:'{file}.js'
}
,
module:{
    test:/\.css$/,
    use:[
        'style-loader',
        'css-loader'
    ]
    }
}


