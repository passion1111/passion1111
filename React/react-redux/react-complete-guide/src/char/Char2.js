import React, { Component } from 'react'

const char=(props)=>{
    const style={
        display:"inline-block",
        padding:"10px",
        margin:"10px",
        border:"1px solid black",
        textAlign:"center"
    }
}

        return (
            <div style={style} onClick={props.clicked}>
                {props.character}
            </div>
        )
  
export default char2
