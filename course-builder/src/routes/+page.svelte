<script>
    import { goto } from "$app/navigation";
  
    </script>
    
    <style>
      /* Minimalistic styling */
      main {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height: 100vh;
        font-family: 'Arial', sans-serif;
        background-color: #f7f7f7;
        color: #333;
      }
    
      h1 {
        font-size: 2rem;
        margin-bottom: 1rem;
      }
    
      a {
        padding: 10px 20px;
        margin: 5px;
        font-size: 1rem;
        border: none;
        background-color: #007BFF;
        color: white;
        cursor: pointer;
        border-radius: 5px;
        transition: background-color 0.3s ease;
      }
    
      button:hover {
        background-color: #0056b3;
      }
    </style>
    
    <main>
      <h1>Welcome</h1>

      <a href = '/aiPower'>AI Power</a>
      
      <button on:click={() => goto('/buildMyself')}>
        Build Myself
      </button>
    </main>
 