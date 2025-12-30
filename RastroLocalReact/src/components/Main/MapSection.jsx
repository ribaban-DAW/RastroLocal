import { FilterIcon, SearchIcon } from '../Icons'
import Map from './Map'

export default function MapSection() {
  return (
    <section className="main__map">
      <h2 className="map__title">Mapa interactivo</h2>
      <button className="map__filter">
        <FilterIcon />
        Filtrar
      </button>
      <div className="map__search">
        <SearchIcon />
        <input className="search__input" type="search" name="" id="" placeholder="Buscar" />
      </div>
      <Map />
    </section>
  )
}
