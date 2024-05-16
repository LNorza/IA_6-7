import cv2

def procesar_imagen(imagen):
    # Convertir a escala de grises de manera vectorizada
    imagen_gris = cv2.cvtColor(imagen, cv2.COLOR_BGR2GRAY)
    return imagen_gris

def main():
    captura = cv2.VideoCapture(0)

    if not captura.isOpened():
        print("Error al abrir la cámara")
        return

    while True:
        ret, fotograma = captura.read()

        if not ret:
            print("Error al capturar fotograma")
            break

        # Redimensionar la imagen para reducir el tiempo de procesamiento
        fotograma_redimensionado = cv2.resize(fotograma, (0, 0), fx=0.5, fy=0.5)

        imagen_procesada = procesar_imagen(fotograma_redimensionado)

        cv2.imshow('Imagen procesada', imagen_procesada)

        if cv2.waitKey(1) & 0xFF == ord('q'):
            break

    captura.release()
    cv2.destroyAllWindows()

if __name__ == "__main__":
    main()
