import './App.css'

import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'

import Header from './components/Header/Header'
import Footer from './components/Footer/Footer'

import { ContactPage, HomePage, MapPage, NoticePage } from './pages'

function App() {
  return (
    <Router>
      <Header />

      <main className="main">
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/map" element={<MapPage />} />
          <Route path="/notice" element={<NoticePage />} />
          <Route path="/contact" element={<ContactPage />} />
        </Routes>
      </main>

      <Footer />
    </Router>
  )
}

export default App
