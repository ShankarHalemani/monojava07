import React, { useState } from 'react'
import { useDispatch } from 'react-redux'
import { amountSlice } from '../state/slice/amountSlice'


const Amount = () => {
    const dispacth = useDispatch()
    const [amountOfComponent, setAmountOfComponent] = useState()
    const add = (e) => {
        dispacth(amountSlice.actions.addToAmount(amountOfComponent))
    } //setting values of state variable}
    const sub = (e) => {
        dispacth(amountSlice.actions.subToAmount(amountOfComponent))
    }//setting values of state variable }
    return (
        <>
            <button onClick={add}>+</button>
            <input type='text' onChange={e => setAmountOfComponent(e.target.value)} />
            <button onClick={sub}>-</button>
        </>
    )
}

export default Amount