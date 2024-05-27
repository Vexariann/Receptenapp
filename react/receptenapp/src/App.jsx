import { useEffect, useState } from 'react'
import './App.css'

// TODO:
// read up on mapping in react
// fetch should be done within the useEffect and the data should be saved within useState as an array
// mapping in react can already render HTML. see it as some kind of foreach loop that is writing the foreach loop for you

function GetRecipes() {
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
  const [recipes, setRecipes] = useState()

  // useEffect(() => {
  //   GetRecipes();
  // }, []);

  useEffect(() => { fetch("https://localhost:8080/api/v1/recipe").then((response) => setRecipes(response)) }, []);

  const postNewRecipe = (event) => {
    //event.preventDefault();
    console.log(`You posted '${title}'`);
    const requestOptions = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ title: `${title}` })
    };
    fetch("http://localhost:8080/api/v1/recipe/create-recipe", requestOptions)
      .then(response => response.json());
  }

  return (
    <>
      <ul id='recipesList'></ul>
      <form onSubmit={postNewRecipe}>
        <input type="text" value={title} onChange={(e) => setTitle(e.target.value)} />
        <input type="submit" />
      </form>
    </>
  );
}

export default App
