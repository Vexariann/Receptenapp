import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function GetRecipes() {
  //fetch("http://localhost:8080/api/v1/recipe").then(response => response.json()).then((data) => data.forEach(data => { console.log("id: ", data.id, " title: ", data.title) })).catch(error => console.error(error));
  fetch("http://localhost:8080/api/v1/recipe")
    .then(response => response.json())
    .then((data) => data.forEach(data => { CreateElement(data); }))
    .catch(error => console.error(error));
}

function CreateElement(data) {
  const element = document.getElementById('recipesList');
  const newListItem = document.createElement('li');
  newListItem.innerHTML =
    `
    id: ` + data.id + `<br>
    title: ` + data.title + `<br><br>
  `;
  element.appendChild(newListItem);
}

function App() {
  const [count, setCount] = useState(0)

  useEffect(() => {
    GetRecipes();
  }, []);

  return (
    <>
      <ul id='recipesList'></ul>
    </>
  )
}

export default App
