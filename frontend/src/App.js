import { useEffect, useState } from "react";

const baseURL = process.env.REACT_APP_SERVER
const apiUrl = `${baseURL}/movie`;

function App() {
  const [movie, setMovie] = useState({} )
  useEffect(()=> {    
    const init = async() => {
      const response = await fetch(`${apiUrl}/1`)
      const json = await response.json()
      console.log(json)
      setMovie(json)
    }
    init()
  }, [])

  return <div>영화정보출력: {apiUrl} <br/> {movie.title} <br/>       </div>
}
export default App;
