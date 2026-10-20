import { useEffect, useState } from 'react'
import Navbar from './components/navbar'
import { getJuegos } from './services/juegos'
import './App.css'

function App() {
  const [juegos, setJuegos] = useState([])
  const [cargando, setCargando] = useState(true)
  const [error, setError] = useState('')

  useEffect(() => {
    let activo = true

    getJuegos()
      .then((juegosCargados) => {
        if (activo) setJuegos(juegosCargados)
      })
      .catch((errorCarga) => {
        if (activo) setError(errorCarga.message)
      })
      .finally(() => {
        if (activo) setCargando(false)
      })

    return () => {
      activo = false
    }
  }, [])

  return (
    <>
      <Navbar />
      <main>
        <section className="hero" id="inicio">
          <div className="hero-content">
            <p className="eyebrow">Bienvendido a JogOnline</p>
            <h1>Disfruta de tu <span>juego favorito.</span></h1>
            <p className="hero-description">
              Explora juegos, descubre nuevas aventuras y encuentra algo para
              cada forma de jugar.
            </p>
            <a className="hero-button" href="#juegos">
              Ver juegos <span aria-hidden="true">→</span>
            </a>
          </div>
          <div className="hero-art" aria-hidden="true">
            <div className="art-orbit orbit-one" />
            <div className="art-orbit orbit-two" />
            <div className="art-card">
              <span className="art-symbol">✦</span>
              <span className="art-caption">PLAY YOUR WAY</span>
            </div>
          </div>
        </section>
        <section className="games-section" id="juegos">
          <h2>Catálogo de juegos</h2>
          {cargando ? (
            <p className="games-message" role="status">Cargando juegos...</p>
          ) : error ? (
            <p className="games-message games-error" role="alert">{error}</p>
          ) : juegos.length === 0 ? (
            <p className="games-message">Todavía no hay juegos en el catálogo.</p>
          ) : (
            <div className="games-grid">
              {juegos.map((juego) => (
                <article className="game-card" key={juego.id}>
                  {juego.image && (
                    <img
                      className="game-image"
                      src={juego.image}
                      alt={`Imagen de ${juego.title}`}
                    />
                  )}
                  <div className="game-card-content">
                    <p className="game-category">{juego.category || juego.genre}</p>
                    <h3>{juego.title}</h3>
                    <p>{juego.description}</p>
                    {juego.enlacejuego && (
                      <a href={juego.enlacejuego} target="_blank" rel="noreferrer">
                        Jugar <span aria-hidden="true">→</span>
                      </a>
                    )}
                  </div>
                </article>
              ))}
            </div>
          )}
        </section>
      </main>
    </>
  )
}

export default App
