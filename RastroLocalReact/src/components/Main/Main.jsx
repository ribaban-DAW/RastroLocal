import MapSection from './MapSection'
import CategoriesSection from './CategoriesSection'
import PostsSection from './PostsSection'
import PostCardsSection from './PostCardsSection'

export default function Main() {
  return (
    <main className="main">
      <MapSection />
      <CategoriesSection />
      <PostsSection />
      <PostCardsSection />
    </main>
  )
}

