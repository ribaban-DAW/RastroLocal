import { useState } from 'react'
import Post from './Post'

export default function PostsSection() {
  const [posts] = useState([
    { title: "Empanadas Don Carlos", description: "Las mejores empanadas artesanales de la ciudad", location: "Zona A, Puesto 12" },
    { title: "Tejidos Manuela", description: "Bordados y tejidos hechos a mano", location: "Zona B, Puesto 7" },
    { title: "Ropa Sustentable", description: "Moda ecológica y de segunda mano", location: "Zona C, Puesto 3" },
  ])

  return (
    <section className="main__posts">
      <h2 className="posts__title">Puestos Destacados</h2>
      <div className="post__container">
        {posts.map((post, index) => (
          <Post key={index} post={post} />
        ))}
      </div>
    </section>
  )
}
