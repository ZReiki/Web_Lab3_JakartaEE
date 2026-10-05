<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Input data</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
  <div class="main-page">
    <h1>Лабораторна робота№3 - JakartaEE</h1>
    <hr>
    <p>
      Протабулювати функцію:
    </p>
    <%--    Красивий вивід функції--%>
    <math display="block">
      <mi>y</mi><mo>=</mo><mo>{</mo>
      <mtable>
        <mtr>
          <mrow>
            <mo>sin</mo><mi>x</mi>
            <mo>lg</mo><mi>x</mi>
          </mrow>
        </mtr>
        <mtr>
          <mrow>
            <msup><mo>cos</mo><mn>2</mn></msup><mi>x</mi>
          </mrow>
        </mtr>
      </mtable>
      <mtext>,&nbsp</mtext>
      <mtable>
        <mtr>
          <mrow><mi>x</mi><mo>></mo><mn>3.4</mn></mrow>
        </mtr>
        <mtr>
          <mrow><mi>x</mi><mo>≤</mo><mn>3.4</mn></mrow>
        </mtr>
      </mtable>
    </math>

    <hr>

    <form method="post" action="${pageContext.request.contextPath}/tabulation">
      <label>Початок діапазону:
        <input type="number" name="a" value="2"/>
      </label>
      <label>Кінець діапазону:
        <input type="number" name="b" value="5"/>
      </label>
      <label >Крок:
        <input type="number" name="h" value="0.005" step="0.001"/>
      </label>
      <button type="submit">Прорахувати</button>
    </form>
  </div>
</body>
</html>