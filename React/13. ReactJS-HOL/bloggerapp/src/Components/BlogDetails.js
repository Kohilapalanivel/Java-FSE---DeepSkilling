function BlogDetails() {
  const blogs = [
    {
      title: "React Learning",
      author: "Stephen Biz",
      description: "Welcome to learning React!"
    },
    {
      title: "Installation",
      author: "Schwezdenier",
      description: "You can install React from npm."
    }
  ];

  return (
    <>
      {blogs.map((blog, index) => (
        <div key={index}>
          <h3>{blog.title}</h3>
          <strong>{blog.author}</strong>
          <p>{blog.description}</p>
        </div>
      ))}
    </>
  );
}

export default BlogDetails;