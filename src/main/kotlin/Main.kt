// Базовый класс - точка
open class Point(x: Double, y: Double) {
    var x: Double = x
    var y: Double = y

    open fun printInfo() {
        println("Точка: ($x, $y)")
    }
}

// Производный класс - цветная точка
class ColoredPoint(x: Double, y: Double, var color: String) : Point(x, y) {
    override fun printInfo() {
        println("Цветная точка: ($x, $y), Цвет: $color")
    }
}

// Производный класс - линия
open class Line(x1: Double, y1: Double, x2: Double, y2: Double) : Point(x1, y1) {
    var x2: Double = x2
    var y2: Double = y2

    constructor(point1: Point, point2: Point) : this(point1.x, point1.y, point2.x, point2.y)

    override fun printInfo() {
        println("Линия: ($x, $y) - ($x2, $y2)")
    }
}

// Производный класс - цветная линия
class ColoredLine(x1: Double, y1: Double, x2: Double, y2: Double, var color: String) : Line(x1, y1, x2, y2) {
    constructor(point1: Point, point2: Point, color: String) : this(point1.x, point1.y, point2.x, point2.y, color)

    override fun printInfo() {
        println("Цветная линия: ($x, $y) - ($x2, $y2), Цвет: $color")
    }
}

// Производный класс - многоугольник
class Polygon(vararg points: Point) {
    var points: Array<Point> = points.toTypedArray()

    fun moveOX(distance: Double) {
        for (point in points) {
            point.x += distance
        }
    }

    fun moveOY(distance: Double) {
        for (point in points) {
            point.y += distance
        }
    }

    fun move(distanceX: Double, distanceY: Double) {
        for (point in points) {
            point.x += distanceX
            point.y += distanceY
        }
    }

    fun printInfo() {
        println("Многоугольник:")
        for (point in points) {
            point.printInfo()
        }
    }
}

fun main() {
    val point = Point(1.0, 2.0)
    val coloredPoint = ColoredPoint(3.0, 4.0, "Красный")
    val line = Line(1.0, 2.0, 3.0, 4.0)
    val coloredLine = ColoredLine(1.0, 2.0, 3.0, 4.0, "Синий")
    val polygon = Polygon(Point(1.0, 2.0), Point(3.0, 4.0), Point(5.0, 6.0))

    val objects = arrayOf(point, coloredPoint, line, coloredLine, polygon)

    for (obj in objects) {
        obj.printInfo()
    }

    polygon.moveOX(10.0)
    polygon.moveOY(5.0)
    polygon.printInfo()
}
