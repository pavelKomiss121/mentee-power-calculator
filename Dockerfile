# Используем образ с JDK для компиляции
FROM openjdk:21-jdk-slim AS builder
# Устанавливаем рабочую директорию
WORKDIR /app
# Создаем структуру пакетов
RUN mkdir -p ru/mentee/power
# Копируем исходные файлы Java в правильную структуру пакетов
COPY src/main/java/ru/mentee/power/Calculator.java ru/mentee/power/
COPY src/main/java/ru/mentee/power/Main.java ru/mentee/power/
# Компилируем Java файлы с учетом пакетов
RUN javac ru/mentee/power/Calculator.java ru/mentee/power/Main.java

# Используем более легкий образ с JRE для runtime
FROM openjdk:21-jdk-slim
# Устанавливаем рабочую директорию
WORKDIR /app
# Копируем скомпилированные .class файлы из builder stage с сохранением структуры
COPY --from=builder /app/ru/ ./ru/
# Устанавливаем точку входа для запуска приложения с указанием полного имени класса
CMD ["java", "ru.mentee.power.Main"]
