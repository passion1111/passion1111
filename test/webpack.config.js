const path = require('path');

module.exports = {
  mode: "development", // "production" | npm "development" | "none"
  
  // Chosen mode tells webpack to use its built-in optimizations accordingly.
  entry: {index:"./source2/index.js",
          about:"./source2/about.js"}
  , // string | object | array
  // defaults to ./src
  // Here the application starts executing
  // and webpack starts bundling
  output: {
    // options related to how webpack emits results
    path: path.resolve(__dirname, "public"), // string
    // the target directory for all output files
    // must be an absolute path (use the Node.js path module)
    filename: "[name]_bundle2.js", // string
    
  }
,
  module:{
        rules:[
            {
                test:/\.css$/,
                use:[
                    'style-loader',
                    'css-loader'
                ]
            }


        ]
  }
}