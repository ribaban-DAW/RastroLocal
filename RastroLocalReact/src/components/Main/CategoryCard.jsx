import { Link } from 'react-router-dom'

export default function CategoryCard({ category }) {
  const { icon, title, posts, link } = category
  return (
    <Link to={link} style={{ textDecoration: "none" }}>
      <article className={ `category ${link !== "#" ? "category--premium" : ""}` }>
        {icon}
        <h3 className="category__title">{title}</h3>
        <p className="category__posts">{posts}</p>
      </article>
    </Link>
  )
}
