export async function getJuegos() {
  const response = await fetch('/api/juego')

  if (!response.ok) {
    throw new Error(`No se pudieron cargar los juegos (HTTP ${response.status})`)
  }

  const juegos = await response.json()

  if (!Array.isArray(juegos)) {
    throw new Error('La respuesta del servidor no contiene una lista de juegos')
  }

  return juegos
}
