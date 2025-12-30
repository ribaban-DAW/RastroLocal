import { LocationIcon } from '../Icons'

export default function Post({ post }) {
  const { title, description, location } = post
  return (
    <article className="post">
      <h3 className="post__title">{title}</h3>
      <p className="post__description">{description}</p>
      <div className="post__location">
        <LocationIcon />
        <p className="location__text">{location}</p>
      </div>
    </article>
  )
}
