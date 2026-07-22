import "./App.css";
import CourseDetails from "./Components/CourseDetails";
import BookDetails from "./Components/BookDetails";
import BlogDetails from "./Components/BlogDetails";

function App() {
  return (
    <div className="container">
      <div className="column">
        <h2>Course Details</h2>
        <CourseDetails />
      </div>

      <div className="column">
        <h2>Book Details</h2>
        <BookDetails />
      </div>

      <div className="column">
        <h2>Blog Details</h2>
        <BlogDetails />
      </div>
    </div>
  );
}

export default App;
