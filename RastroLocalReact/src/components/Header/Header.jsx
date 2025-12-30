import Nav from './Nav'
import { MarkIcon, LoginIcon, SearchIcon } from '../Icons'

export default function Header() {
  return (
    <header className="header">
      <div className="header__mark">
        <MarkIcon />
        <h1 className="mark__text">RastroLocal</h1>
      </div>
      <Nav />
      <div className="header__action">
        <SearchIcon />
        <LoginIcon />
      </div>
    </header>
  )
}
