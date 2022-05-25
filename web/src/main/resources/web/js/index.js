(function () {
  let request = new XMLHttpRequest();
  request.open("GET", "http://localhost:8080/g:get-articles");
  request.responseType = "text";
  request.onload = () => inflateArticles(request);
  request.send();
})()

function inflateArticles(request) {
  let container = document.getElementById("main-container");
  let parsedElements = parseHtmlStringToDom(request.responseText,
      "article-card");
  for (let element of parsedElements) {
    container.appendChild(element);
  }
}

function parseHtmlStringToDom(string, classNameToUnwrap) {
  let domParser = new DOMParser();
  let htmlDom = domParser.parseFromString(string, "text/html");
  return htmlDom.getElementsByClassName(classNameToUnwrap);
}
