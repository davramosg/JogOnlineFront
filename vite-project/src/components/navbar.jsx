import { useState } from 'react'
import './navbar.css'

function Navbar() {
  const [menuOpen, setMenuOpen] = useState(false)

  const closeMenu = () => setMenuOpen(false)

  return (
    <header className="site-header">
      <nav className="navbar" aria-label="Navegación principal">
        <a className="navbar-brand" href="#inicio" onClick={closeMenu}>
          <img src="/path/to/logo.png" alt="" />
          <span>Jog<span className="letra2">Online</span></span>
        </a>

        <button
          className="navbar-toggle"
          type="button"
          aria-label={menuOpen ? 'Cerrar menú' : 'Abrir menú'}
          aria-expanded={menuOpen}
          aria-controls="navbar-links"
          onClick={() => setMenuOpen((open) => !open)}
        >
          <span />
          <span />
          <span />
        </button>

        <div
          className={`navbar-links${menuOpen ? ' is-open' : ''}`}
          id="navbar-links"
        >
          <a href="#inicio" onClick={closeMenu}>Inicio</a>
          <a href="#juegos" onClick={closeMenu}>Juegos</a>
          <a className="navbar-cta" href="#juegos" onClick={closeMenu}>
            Explorar juegos <span aria-hidden="true">→</span>
          </a>
        </div>
      </nav>
    </header>
  )
}

export default Navbar
