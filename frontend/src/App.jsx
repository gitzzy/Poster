import './App.css'
import {Routes,Route,Router} from 'react-router-dom';
import HomePage from './components/HomePage/HomePage';
import Authentication from './components/Authentication/Authentication';

function App() {

  return (
    <>
     <Routes>
        <Route path='/' element={true?<HomePage/>:<Authentication/>}>
        
        </Route>
     </Routes>
    </>
  )
}

export default App
