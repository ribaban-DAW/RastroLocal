import { useState } from 'react'
import PostCard from './PostCard'

export default function PostCardsSection() {
  const [postCards] = useState([
    { title: 'Panadería Artes "El Trigo"', description: 'Pan recién horneado todos los días con ingredientes orgánicos y locales. Ofrecemos una variedad de panes, pasteles y productos de repostería tradicionales.', location: 'Zona Central, Puesto 15', phone: '+34 952 33 33 33', date: 'Jueves 09:00 - 14:00', email: 'contacto@eltrigo.es' },
  ])
  
  return (
    <section className="main__post_cards">
      <h2 className="post_cards__title">Ficha de Puesto</h2>
      {postCards.map((postCard, index) => (
        <PostCard key={index} postCard={postCard} />
      ))}
    </section>
  )
}
