package com.example.integradora_android_4a.utils

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

class SensorUtils(context: Context) {

    private val sensorManager: SensorManager =
        context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

    private var accelerometerListener: SensorEventListener? = null

    /**
     * Registra un listener para el acelerómetro.
     * @param callback función que recibe los valores del acelerómetro en tiempo real.
     */
    fun registerAccelerometerListener(callback: (x: Float, y: Float, z: Float) -> Unit) {
        val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        if (accelerometer != null) {
            accelerometerListener = object : SensorEventListener {
                override fun onSensorChanged(event: SensorEvent?) {
                    event?.values?.let {
                        callback(it[0], it[1], it[2])
                    }
                }

                override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
                    // No se requiere manejo especial
                }
            }
            sensorManager.registerListener(
                accelerometerListener,
                accelerometer,
                SensorManager.SENSOR_DELAY_NORMAL
            )
        }
    }

    /**
     * Cancela el registro del listener para ahorrar recursos.
     */
    fun unregisterAccelerometerListener() {
        accelerometerListener?.let {
            sensorManager.unregisterListener(it)
        }
    }
}