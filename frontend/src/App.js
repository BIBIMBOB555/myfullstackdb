import { useEffect, useState } from "react";

const baseURL = process.env.REACT_APP_SERVER;
const apiUrl = `${baseURL}/movie`;

function App() {
  const [movie, setMovie] = useState({});
  const [currentIdx, setCurrentIdx] = useState(1);
  const [lastIdx, setLastIdx] = useState(null); // 마지막 인덱스 상태 추가
  const [newMovie, setNewMovie] = useState({
    title: "",
    image: "",
    content: ""
  });

  useEffect(() => {
    const fetchLastIdx = async () => {
      const response = await fetch(`${apiUrl}`);
      const movies = await response.json();
      const maxIdx = Math.max(...movies.map(movie => movie.idx));
      setLastIdx(maxIdx);
    };

    fetchLastIdx();
  }, []);

  useEffect(() => {
    const fetchMovie = async () => {
      const response = await fetch(`${apiUrl}/${currentIdx}`);
      const json = await response.json();
      setMovie(json);
    };

    fetchMovie();
  }, [currentIdx]);

  const fetchNextMovie = () => {
    if (currentIdx === lastIdx) {
      setCurrentIdx(1);
    } else {
      setCurrentIdx(prevIdx => prevIdx + 1);
    }
  };

  const fetchPreviousMovie = () => {
    if (currentIdx === 1) {
      setCurrentIdx(lastIdx);
    } else {
      setCurrentIdx(prevIdx => prevIdx - 1);
    }
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewMovie(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const response = await fetch(apiUrl, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(newMovie),
    });
    if (response.ok) {
      alert("영화가 추가되었습니다.");
      setNewMovie({ title: "", image: "", content: "" });
      const moviesResponse = await fetch(`${apiUrl}`);
      const movies = await moviesResponse.json();
      const maxIdx = Math.max(...movies.map(movie => movie.idx));
      setLastIdx(maxIdx);
    } else {
      alert("영화 추가에 실패했습니다.");
    }
  };

  return (
    <div>
      --- 영화DB: {apiUrl} ---<br/>
      {movie.title} <br/>
      {movie.image} <br/>
      {movie.content} <br/>
      <button onClick={fetchPreviousMovie}>이전 영화</button> {/* 이전 영화 버튼 추가 */}
      <button onClick={fetchNextMovie}>다음 영화</button> {/* 다음 영화 버튼 */}
      <br/>
      <h2>새 영화 추가</h2>
      <form onSubmit={handleSubmit}>
        <label>
          제목:
          <input
            type="text"
            name="title"
            value={newMovie.title}
            onChange={handleInputChange}
          />
        </label>
        <br/>
        <label>
          이미지:
          <input
            type="text"
            name="image"
            value={newMovie.image}
            onChange={handleInputChange}
          />
        </label>
        <br/>
        <label>
          내용:
          <textarea
            name="content"
            value={newMovie.content}
            onChange={handleInputChange}
          />
        </label>
        <br/>
        <button type="submit">제출</button>
      </form>
    </div>
  );
}

export default App;
