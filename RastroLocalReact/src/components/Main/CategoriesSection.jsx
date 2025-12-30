import { useState } from 'react'
import { FoodIcon, ClothesIcon, CraftworkIcon, BookIcon, MusicIcon } from '../Icons'
import CategoryCard from './CategoryCard'

export default function CategoriesSection() {
  const [categories] = useState([
    { id: 'food', title: 'Alimento', posts: '15 puestos', icon: <FoodIcon />, link: "#" },
    { id: 'clothes', title: 'Ropa', posts: '8 puestos', icon: <ClothesIcon />, link: "/clothes" },
    { id: 'craft', title: 'Artesanía', posts: '12 puestos', icon: <CraftworkIcon />, link: "#" },
    { id: 'book', title: 'Libro', posts: '5 puestos', icon: <BookIcon />, link: "#" },
    { id: 'music', title: 'Música', posts: '3 puestos', icon: <MusicIcon />, link: "#" },
  ]);

  return (
    <section className="main__categories">
      <h2 className="categories__title">Categorías</h2>
      <div className="categories__container">
        {categories.map(category => {
          return <CategoryCard key={category.id} category={category}/>
        })}
      </div>
    </section>
  )
}
