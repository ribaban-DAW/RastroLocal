export default function ClothesCard({ clothe }) {
  const { image, title, description, price } = clothe;

  return (
    <article className="clothes_card">
      <img className="clothes_card__img" src={image} alt={title} width={150} />
      <h3 className="clothes_card__title">{title}</h3>
      <p className="clothes_card__description">{description}</p>
      <p className="clothes_card__price"><strong>{price.toFixed(2)} €</strong></p>
    </article>
  )
}
