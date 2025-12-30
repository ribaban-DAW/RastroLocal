export default function CategoryCard({ icon, title, posts }) {
  return (
    <article className="category">
      {icon}
      <h3 className="category__title">{title}</h3>
      <p className="category__posts">{posts}</p>
    </article>
  )
}
