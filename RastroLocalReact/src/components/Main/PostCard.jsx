import { LocationIcon, PhoneIcon, DateIcon, EmailIcon, SaveIcon, ShareIcon } from '../Icons'

export default function PostCard({ postCard }) {
  const { title, description, location, phone, date, email } = postCard

  return (
    <article className="post_card">
      <h3 className="post_card__title">{title}</h3>
      <p className="post_card__description">{description}</p>

      {location && (
        <div className="post_card__location">
          <LocationIcon />
          <p className="location__text">{location}</p>
        </div>
      )}

      {phone && (
        <div className="post_card__phone">
          <PhoneIcon />
          <p className="phone__text">{phone}</p>
        </div>
      )}

      {date && (
        <div className="post_card__date">
          <DateIcon />
          <p className="date__text">{date}</p>
        </div>
      )}

      {email && (
        <div className="post_card__email">
          <EmailIcon />
          <p className="email__text">{email}</p>
        </div>
      )}

      <button className="post_card__save">
        <SaveIcon />
        Guardar
      </button>
      <button className="post_card__share">
        <ShareIcon />
        Compartir
      </button>
    </article>
  )
}
