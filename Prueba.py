from tensorflow.keras import layers, models
from tensorflow.keras.utils import to_categorical
import tensorflow as tf
# from tensorflow.keras.datasets import mnist
import matplotlib.pyplot as plt
import cv2
import numpy as np

model = models.Sequential([
    layers.Conv2D(32, (3, 3), activation='relu', input_shape=(28, 28, 1)),
    layers.MaxPooling2D((2, 2)),
    layers.Conv2D(64, (3, 3), activation='relu'),
    layers.MaxPooling2D((2, 2)),
    layers.Conv2D(64, (3, 3), activation='relu'),
    layers.Flatten(),
    layers.Dense(64, activation='relu'),
    layers.Dense(10, activation='softmax')
])

model.summary()


def capture_image_and_classify(model):
    # Iniciar la cámara
    cap = cv2.VideoCapture(0)

    if not cap.isOpened():
        print("Error: No se pudo abrir la cámara.")
        return

    while True:
        # Leer el frame de la cámara
        ret, frame = cap.read()

        if not ret:
            print("Error: No se pudo capturar el fotograma.")
            break

        # Mostrar el frame de la cámara
        cv2(frame)

        # Esperar a que se presione la tecla 'q' para salir
        if cv2.waitKey(1) & 0xFF == ord('q'):
            break

        # Convertir la imagen a escala de grises
        gray_image = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)

        # Redimensionar la imagen a 28x28
        resized_image = cv2.resize(gray_image, (28, 28))

        # Normalizar la imagen
        normalized_image = resized_image.reshape((1, 28, 28, 1)).astype('float32') / 255

        # Predecir la etiqueta usando el modelo entrenado
        predicted_label = np.argmax(model.predict(normalized_image))

        # Mostrar la predicción
        print(f'Predicted Label: {predicted_label}')

    # Liberar la cámara y cerrar todas las ventanas
    cap.release()
    cv2.destroyAllWindows()

capture_image_and_classify(model)