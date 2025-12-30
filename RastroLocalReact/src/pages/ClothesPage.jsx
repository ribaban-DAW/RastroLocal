import { useEffect, useState } from 'react'
import axios from 'axios'

import ClothesCard from '../components/ClothesCard'

export default function ClothesPage() {
  const [clothes, setClothes] = useState([])
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    axios.get("https://fakestoreapi.com/products/category/men's%20clothing")
      .then(res => {
        setClothes(res.data)
        setLoading(false)
      })
      .catch(err => {
        console.log(`Error al cargar ropa: ${err}`)
        setLoading(false)
      })
  }, [])

  if (loading) return <p>Cargando ropa...</p>

  return (
    <section className="clothes">
      <h2 className="clothes__title">Ropa Disponible</h2>
      <div className="clothes_container">
        {clothes.map((clothe, index) => (
          <ClothesCard key={index} clothe={clothe} />
        ))}
      </div>
    </section>
  )
}
