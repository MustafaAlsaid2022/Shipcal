import React from 'react'
import './index.css'
import { BrowserRouter as Router, Route, Routes, Link, Navigate } from 'react-router-dom'
import CreateShipment from './pages/CreateShipment'
import AllShipment from './pages/AllShipment'
import { render } from 'react-dom'
const App = () => (
  <Router>
    <div>
      <ul>
        <li className='inline'>
          <Link to='/addBoxes'>Create Shipment</Link>
        </li>
        <li className='inline'>
          <Link to='/listBoxes'>All Shipment</Link>
        </li>
      </ul>

      <hr />
      <Routes>
        <Route path='/addBoxes' element={<CreateShipment />} exact />
        <Route path='/listBoxes' element={<AllShipment />} exact />
        <Route path='/' element={<Navigate to='/listBoxes' replace />} />
      </Routes>
    </div>
  </Router>
);

render(<App />, document.getElementById('root'))
